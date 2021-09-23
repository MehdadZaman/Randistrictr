import React, { useState, useMemo } from 'react';
import { MapContainer, TileLayer, ZoomControl, GeoJSON } from 'react-leaflet';
import Position from './Position';
import { center, zoom, bounds } from '../constants/map';
import Sidebar from './sidebar';
import Navbar from './navbar';
// import MaryLandGEOJSON from '../constants/cb_2020_24_bg_500k.json';
import MaryLandCongressionalDistricts from '../constants/congressional-districts/maryland_congressional_districts.json';
import MichiganCongressionalDistricts from '../constants/congressional-districts/michigan_congressional_districts.json';
import UtahCongressionalDistricts from '../constants/congressional-districts/utah_congressional_districts.json';

import MaryLandVotingDistricts from '../constants/voting districts/maryland_voting_simplified.json';
import MichiganVotingDistricts from '../constants/voting districts/michigan_voting_simplified.json';
import UtahVotingDistricts from '../constants/voting districts/utah_voting_simplified.json';

const Map = () => {
  const [map, setMap] = useState(null);

  const displayMap = useMemo(
    () => (
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
        <GeoJSON data={MaryLandCongressionalDistricts} />
        <GeoJSON data={MichiganCongressionalDistricts} />
        <GeoJSON data={UtahCongressionalDistricts} />
        <ZoomControl position='bottomright' />
      </MapContainer>
    ),
    []
  );

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
