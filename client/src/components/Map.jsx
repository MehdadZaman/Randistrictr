import React, { useState, useMemo } from 'react';
import {
  MapContainer,
  TileLayer,
  ZoomControl,
  GeoJSON,
  useMapEvents,
  Pane,
} from 'react-leaflet';
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
  const [activeGeoJSON, setActiveGeoJSON] = useState(null);
  const [votingGeoJSON, setVotingGeoJSON] = useState();
  const [leftSidebarExpanded, setLeftSidebarExpanded] = useState(false);
  const [rightSidebarExpanded, setRightSidebarExpanded] = useState(false);

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
        fillOpacity: 0.3,
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
        setSelectedState(NAME);
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
              style={{ color: 'green', fillOpacity: 0.2 }}
            />
          ) : null}
        </Pane>
        <Pane name='voting' style={{ zIndex: 400 }}>
          {votingGeoJSON ? (
            <GeoJSON
              data={votingGeoJSON}
              style={{ color: '#3388ff', fillOpacity: 0.2 }}
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

  const handleSelect = (districting) => {
    switch (selectedState) {
      case 'Maryland': {
        setActiveGeoJSON(MarylandCongressionalDistricts);
        setRightSidebarExpanded(true);
        break;
      }
      case 'Michigan': {
        setActiveGeoJSON(MichiganCongressionalDistricts);
        setRightSidebarExpanded(true);
        break;
      }
      case 'Utah': {
        setActiveGeoJSON(UtahCongressionalDistricts);
        setRightSidebarExpanded(true);
        break;
      }
      default: {
        setActiveGeoJSON(null);
        setRightSidebarExpanded(false);
        break;
      }
    }
  };

  const handleReset = () => {
    setActiveGeoJSON(null);
    setLeftSidebarExpanded(false);
    setRightSidebarExpanded(false);
    setSelectedState('');
    map.fitBounds(bounds);
  };
  return (
    <>
      {map ? (
        <Navbar
          map={map}
          selectedState={selectedState}
          onReset={handleReset}
          onSelect={(state) => {
            if (state) {
              setLeftSidebarExpanded(true);
              setRightSidebarExpanded(true);
            } else {
              setLeftSidebarExpanded(false);
              setRightSidebarExpanded(false);
            }
            setActiveGeoJSON(null);
            setSelectedState(state);
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
              <TabView selectedState={selectedState} onSelect={handleSelect} />
            ) : (
              <h1 style={{ fontSize: '3vh', transform: 'translateY(350%)' }}>
                Please select a state to continue
              </h1>
            )}
          </Sidebar>
        ) : null}

        {displayMap}
        {map ? (
          <Sidebar
            expanded={rightSidebarExpanded}
            onToggle={() => setRightSidebarExpanded(!rightSidebarExpanded)}
            map={map}
            position='right'
            width={450}
          >
            <DistrictingDetails
              selectedState={selectedState}
              isDistrictSelected={!!activeGeoJSON}
            />
          </Sidebar>
        ) : null}
      </div>
    </>
  );
};

export default Map;
