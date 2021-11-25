import React, { useState, useMemo, useEffect } from 'react';
import {
  MapContainer,
  TileLayer,
  ZoomControl,
  GeoJSON,
  useMapEvents,
  Pane,
} from 'react-leaflet';
import {
  Select,
  Modal,
  ModalOverlay,
  ModalContent,
  ModalHeader,
  ModalFooter,
  ModalBody,
  ModalCloseButton,
} from '@chakra-ui/react';
import { center, zoom, bounds } from '../constants/map';
// Components
import Navbar from './navbar';
import Sidebar from './sidebar';
import Position from './Position';
import TabView from './TabView';
import DistrictingDetails from './DistrictingDetails';
// JSON
import statesdata from '../json/states.json';
import MarylandCongressionalDistricts from '../json/congressional-districts/maryland_congressional_districts.json';
import MichiganCongressionalDistricts from '../json/congressional-districts/michigan_congressional_districts.json';
import UtahCongressionalDistricts from '../json/congressional-districts/utah_congressional_districts.json';
import MarylandVotingDistricts from '../json/voting districts/maryland_voting_simplified.json';
import MichiganVotingDistricts from '../json/voting districts/michigan_voting_simplified.json';
import UtahVotingDistricts from '../json/voting districts/utah_voting_simplified.json';
import useStateRef from '../hooks/useStateRef';
import apiCaller from '../utils/apiCaller';
import BoxAndWhiskerPlot from './BoxAndWhiskerPlot';

const COLOR_0 = '#F06E45';
const COLOR_1 = '#C9A83E';
const COLOR_24 = '#A1A436';
const COLOR_75 = '#789E2D';
const COLOR_140 = '#509923';
const COLOR_222 = '#3eb80e';

function getColor(d) {
  return d > 222
    ? COLOR_222
    : d > 140
    ? COLOR_140
    : d > 75
    ? COLOR_75
    : d > 300
    ? COLOR_24
    : d > 0
    ? COLOR_1
    : COLOR_0;
}
function style(feature) {
  console.log('Feature properties', feature.properties);
  return {
    // fillColor: getColor(feature.properties.COUNT),
    // weight: 1,
    opacity: 1,
    color: '#DF1995', //#3388ff
    fillOpacity: 0.15,
  };
}

const Map = () => {
  const [map, setMap] = useState(null);
  const [selectedState, setSelectedState, selectedStateRef] = useStateRef();
  const [popMeasure, setPopMeasure] = useState('TOTAL');
  const [districtings, setDistrictings] = useState([]);
  const [
    enactedDistrictingPlanStatistics,
    setEnactedDistrictingPlanStatistics,
  ] = useState(null);
  const [districtingPlanStatistics, setDistrictingPlanStatistics] =
    useState(null);
  const [activeGeoJSON, setActiveGeoJSON] = useState(null);
  const [votingGeoJSON, setVotingGeoJSON] = useState();
  const [leftSidebarExpanded, setLeftSidebarExpanded] = useState(false);
  const [rightSidebarExpanded, setRightSidebarExpanded] = useState(false);
  const [algorithmStarted, setAlgorithmStarted] = useState(false);
  const [algorithmRunning, setAlgorithmRunning] = useState(false);
  const [boxAndWhiskerPlotOpen, setBoxAndWhiskerPlotOpen] = useState(false);
  const [boxAndWhiskerData, setBoxAndWhiskerData] = useState(null);
  const [boxAndWhiskerPlotOption, setBoxAndWhiskerPlotOption] = useState(0);

  useEffect(() => {
    fetchBoxAndWhiskerData();
  }, [boxAndWhiskerPlotOption]);

  const displayMap = useMemo(() => {
    let mapRef;
    function MapEvents() {
      const map = useMapEvents({
        zoomend: () => {
          onZoomEnd(map);
        },
        locationfound: (location) => {
          console.log('location found:', location);
        },
      });
      return null;
    }

    const highlightFeature = (e) => {
      let layer = e.target;
      const { NAME } = e.target.feature.properties;
      layer.setStyle({
        // weight: 2,
        // color: '#DF1995',
        dashArray: '',
        fillOpacity: 0.2,
        borderWidth: 0.5,
      });
      // if (!L.Browser.ie && !L.Browser.opera && !L.Browser.edge) {
      //   layer.bringToFront();
      // }
    };
    const resetHighlight = (e) => {
      // setSelected({});
      e.target.setStyle(style(e.target.feature));
    };
    const zoomToFeature = (e) => {
      console.log('TARGET FEATURE', e.target);
      const { NAME } = e.target.feature.properties;
      if (NAME !== selectedStateRef.current) {
        setLeftSidebarExpanded(true);
        setRightSidebarExpanded(true);
        setActiveGeoJSON(null);
        handleSelectState(NAME);
        // setSelectedState(NAME);
      }

      map.fitBounds(e.target.getBounds());
    };

    const onEachFeature = (feature, layer) => {
      layer.on({
        mouseover: highlightFeature,
        mouseout: resetHighlight,
        click: zoomToFeature,
      });
      layer.setStyle({
        color: '#DF1995',
        zIndex: 999,
      });
      // layer.setZIndex(999);
    };

    const onZoomEnd = (map) => {
      const currentZoom = map.getZoom();
      console.log('CZ', currentZoom);
      if (selectedState === 'Maryland' && currentZoom >= 9) {
        setVotingGeoJSON(MarylandVotingDistricts);
      } else if (selectedState === 'Michigan' && currentZoom >= 7) {
        setVotingGeoJSON(MichiganVotingDistricts);
      } else if (selectedState === 'Utah' && currentZoom >= 8) {
        setVotingGeoJSON(UtahVotingDistricts);
      } else {
        setVotingGeoJSON(null);
      }
    };

    return (
      <MapContainer
        className='sidebar-map'
        style={{ height: '91vh', zIndex: 0, minHeight: 390, minWidth: 768 }}
        center={center}
        zoom={zoom}
        scrollWheelZoom={false}
        whenCreated={(map) => {
          console.log('MAP CREATED');
          mapRef = map;
          setMap(map);
        }}
        boundsOptions={bounds}
        maxBounds={bounds}
        minZoom={5}
        zoomControl={false}
      >
        <TileLayer
          attribution='&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
          url='https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png'
        />
        <MapEvents />
        <Pane name='states' style={{ zIndex: 420 }}>
          <GeoJSON data={statesdata} onEachFeature={onEachFeature} />
        </Pane>
        <Pane name='congressional' style={{ zIndex: 410 }}>
          {activeGeoJSON ? (
            <GeoJSON
              data={activeGeoJSON}
              style={{ color: 'green', fillOpacity: 0.2, weight: 3 }}
            />
          ) : null}
        </Pane>
        <Pane name='voting' style={{ zIndex: 400 }}>
          {votingGeoJSON ? (
            <GeoJSON
              data={votingGeoJSON}
              style={{ color: '#3388ff', fillOpacity: 0.2, weight: 1 }}
            />
          ) : null}
        </Pane>

        {/* <GeoJSON data={MaryLandCongressionalDistricts} />
        <GeoJSON data={MichiganCongressionalDistricts} />
        <GeoJSON data={UtahCongressionalDistricts} />
        <GeoJSON data={MaryLandVotingDistricts} />
        <GeoJSON data={MichiganCongressionalDistricts} />
        <GeoJSON data={UtahCongressionalDistricts} /> */}
        <ZoomControl position='bottomright' />
      </MapContainer>
    );
  }, [map, selectedState, activeGeoJSON, votingGeoJSON]);

  const handleSelectState = async (stateName) => {
    try {
      const res = await apiCaller.get('/select/state/population', {
        params: {
          stateName,
        },
      });
      const enactedDistrictingRes = await apiCaller.get(
        '/select/state/enactedDistricting'
      );
      const enactedDistrictingPlanStatisticsRes = await apiCaller.get(
        '/select/state/enactedDistrictingPlanStatistics'
      );
      const allDistrictingPlanStatisticsRes = await apiCaller.get(
        '/select/state/allDistrictingPlanStatistics'
      );
      console.log(stateName);
      console.log(allDistrictingPlanStatisticsRes.data);
      setSelectedState(stateName);
      setEnactedDistrictingPlanStatistics(
        enactedDistrictingPlanStatisticsRes.data
      );
      // setActiveGeoJSON(enactedDistrictingRes.data);
      setDistrictingPlans(allDistrictingPlanStatisticsRes.data);
    } catch (e) {
      console.log(e);
    }
  };

  const handleSelect = async (redistrictNumber) => {
    try {
      console.log(redistrictNumber);
      const res = await apiCaller.get('/select/state/districting', {
        params: { redistrictNumber },
        timeout: 600000,
      });
      const districtPlanStatsRes = await apiCaller.get(
        '/select/districting/districtPlanStatistics'
      );
      setDistrictingPlanStatistics(districtPlanStatsRes.data);
      setActiveGeoJSON(res.data);
      setRightSidebarExpanded(true);
    } catch (e) {
      console.log(e);
    }
  };

  const handleReset = () => {
    setActiveGeoJSON(null);
    setLeftSidebarExpanded(false);
    setRightSidebarExpanded(false);
    setSelectedState('');
    map.fitBounds(bounds);
  };

  const handleRunAlgorithm = async (
    minOpportunity,
    maxOpportunity,
    minThreshold,
    maxDiff,
    maxEffGap,
    minPolsbyPopper,
    numIterations
  ) => {
    try {
      setAlgorithmStarted(true);
      setAlgorithmRunning(true);
      await new Promise((res) => setTimeout(res, 5000));
      const res = await apiCaller.get('/run-algorithm', {
        params: {
          stateName: selectedState,
          minOpportunity,
          maxOpportunity,
          minThreshold,
          maxDiff,
          maxEffGap,
          minPolsbyPopper,
          numIterations,
        },
      });
      setActiveGeoJSON(res.data);
      console.log(res.data);
    } catch (e) {
      console.log(e);
    } finally {
      setAlgorithmRunning(false);
    }
  };

  const handleStopAlgorithm = async () => {
    try {
      setAlgorithmRunning(false);
      await apiCaller.get('/stop-algorithm');
    } catch (e) {
      console.log(e);
    }
  };

  const handlePopMeasureChange = async (popMeasure) => {
    setPopMeasure(popMeasure);
    const res = await apiCaller.post('/select/setPopulationMeasure', {
      populationMeasure: popMeasure,
    });
  };

  const handleShowBoxAndWhiskerPlot = async () => {
    fetchBoxAndWhiskerData();
    setBoxAndWhiskerPlotOpen(true);
  };

  const fetchBoxAndWhiskerData = async () => {
    const res = await apiCaller.get('/select/getBoxAndWhisker', {
      params: { basis: boxAndWhiskerPlotOption },
    });
    setBoxAndWhiskerData(res.data);
  };

  const setDistrictingPlans = (districtingPlanStatistics) => {
    if (districtingPlanStatistics.length > 0) {
      let districtings = [];
      for (let i = 0; i < 30; i++) {
        const districtingPlan = {
          ...districtingPlanStatistics[0],
          redistrictNumber: i,
        };
        districtings.push(JSON.parse(JSON.stringify(districtingPlan)));
      }
      setDistrictings(districtings);
    }
  };

  const boxAndWhiskerPlotOptions = [
    'TOTAL_TOTAL',
    'TOTAL_WHITE',
    'TOTAL_BLACK',
    'TOTAL_HISPANIC',
    'TOTAL_AMERICANINDIAN',
    'TOTAL_ASIAN',
    'TOTAL_HAWAIIAN',
    'TOTAL_OTHER',
    'VAP_TOTAL',
    'VAP_WHITE',
    'VAP_BLACK',
    'VAP_HISPANIC',
    'VAP_AMERICANINDIAN',
    'VAP_ASIAN',
    'VAP_HAWAIIAN',
    'VAP_OTHER',
    'CVAP_TOTAL',
    'CVAP_AMERICANINDIAN',
    'CVAP_ASIAN',
    'CVAP_BLACK',
    'CVAP_HAIWAIIAN',
    'CVAP_WHITE',
    'CVAP_HISPANIC',
    'CVAP_OTHER',
    'DEMOCRAT',
    'REPUBLICAN',
    'OTHER',
  ];

  return (
    <>
      {map ? (
        <Navbar
          map={map}
          selectedState={selectedState}
          popMeasure={popMeasure}
          setPopMeasure={handlePopMeasureChange}
          onReset={handleReset}
          onSelect={(state) => {
            if (state) {
              setLeftSidebarExpanded(true);
              setRightSidebarExpanded(true);
            } else {
              setLeftSidebarExpanded(false);
              setRightSidebarExpanded(false);
            }
            handleSelectState(state);
            // setActiveGeoJSON(null);
            // setSelectedState(state);
          }}
        />
      ) : null}
      <div style={{ position: 'relative', overflow: 'hidden' }}>
        {map ? (
          <Sidebar
            expanded={leftSidebarExpanded}
            onToggle={() => setLeftSidebarExpanded(!leftSidebarExpanded)}
            map={map}
          >
            {selectedState ? (
              <TabView
                districtings={districtings}
                selectedState={selectedState}
                popMeasure={popMeasure}
                onSelect={handleSelect}
                onRun={handleRunAlgorithm}
                onStop={handleStopAlgorithm}
                algorithmStarted={algorithmStarted}
                algorithmRunning={algorithmRunning}
                isDistrictSelected={!!activeGeoJSON}
              />
            ) : (
              <h1 style={{ fontSize: '3vh', transform: 'translateY(350%)' }}>
                Please select a state to continue
              </h1>
            )}
          </Sidebar>
        ) : null}

        {displayMap}
        <Modal
          isOpen={boxAndWhiskerPlotOpen}
          onClose={() => setBoxAndWhiskerPlotOpen(false)}
          closeOnOverlayClick={false}
          isCentered
          size='md'
          useInert={false}
          trapFocus={false}
        >
          <ModalContent style={{ right: 3 }}>
            <ModalCloseButton />
            <ModalHeader>Box and Whisker Plot</ModalHeader>
            <ModalBody>
              <Select
                onChange={(e) => setBoxAndWhiskerPlotOption(e.target.value)}
              >
                {boxAndWhiskerPlotOptions.map((option, i) => (
                  <option value={i}>{option}</option>
                ))}
              </Select>
              <BoxAndWhiskerPlot data={boxAndWhiskerData} />
            </ModalBody>
          </ModalContent>
        </Modal>
        {map ? (
          <Sidebar
            expanded={rightSidebarExpanded}
            onToggle={() => setRightSidebarExpanded(!rightSidebarExpanded)}
            map={map}
            position='right'
            width={450}
          >
            <DistrictingDetails
              data={activeGeoJSON}
              enactedDistrictingPlanStatistics={
                enactedDistrictingPlanStatistics
              }
              districtingPlanStatistics={districtingPlanStatistics}
              selectedState={selectedState}
              popMeasure={popMeasure}
              isDistrictSelected={!!activeGeoJSON}
              showBoxAndWhiskerPlot={handleShowBoxAndWhiskerPlot}
            />
          </Sidebar>
        ) : null}
      </div>
    </>
  );
};

export default Map;
