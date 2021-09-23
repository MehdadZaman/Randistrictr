import React, { useState, useMemo } from 'react';
import { MapContainer, TileLayer, ZoomControl, GeoJSON } from 'react-leaflet';
import Position from './Position';
import { center, zoom, bounds } from '../constants/map';
import Sidebar from './sidebar';
import Navbar from './navbar';
import MaryLandGEOJSON from '../constants/cb_2020_24_bg_500k.json';
import statesdata from '../json/states.json';

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
  return {
    fillColor: getColor(feature.properties.COUNT),
    weight: 1,
    opacity: 1,
    color: 'white',
    dashArray: '3',
    fillOpacity: 0.8,
  };
}

const Map = () => {
  const [map, setMap] = useState(null);
  const [selectedState, setSelectedState] = useState();

  const displayMap = useMemo(() => {
    const highlightFeature = (e) => {
      let layer = e.target;
      // const { NAME_2, NAME_3, COUNT } = e.target.feature.properties;
      // setSelected({
      //   province: `${NAME_3}, ${NAME_2}`,
      //   count: COUNT
      // });
      layer.setStyle({
        weight: 2,
        color: '#DF1995',
        dashArray: '',
        fillOpacity: 1,
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
      console.log('Zoom bounds', e.target.getBounds());
      map.fitBounds(e.target.getBounds());
    };

    const onEachFeature = (feature, layer) => {
      layer.on({
        mouseover: highlightFeature,
        mouseout: resetHighlight,
        click: zoomToFeature,
      });
    };

    return (
      <MapContainer
        className='sidebar-map'
        style={{ height: '91vh', zIndex: 0, minHeight: 390, minWidth: 768 }}
        center={center}
        zoom={zoom}
        scrollWheelZoom={false}
        whenCreated={setMap}
        boundsOptions={bounds}
        maxBounds={bounds}
        minZoom={5}
        zoomControl={false}
      >
        <TileLayer
          attribution='&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
          url='https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png'
        />
        <GeoJSON data={statesdata} onEachFeature={onEachFeature} />
        <ZoomControl position='bottomright' />
      </MapContainer>
    );
  }, [map]);

  return (
    <>
      {map ? <Navbar map={map} /> : null}
      <div style={{ position: 'relative' }}>
        {map ? <Sidebar map={map} /> : null}
        {map ? <Position map={map} /> : null}
        {displayMap}
      </div>
    </>
  );
};

export default Map;
