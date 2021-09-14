import React, { useState, useEffect, useCallback } from 'react';

const center = [-73.11623, 40.914224];
const zoom = 13;

const Position = ({ map }) => {
  const [position, setPosition] = useState(map.getCenter());

  const onClick = useCallback(() => {
    map.setView(center, zoom);
  }, [map]);

  const onMove = useCallback(() => {
    setPosition(map.getCenter());
  }, [map]);

  useEffect(() => {
    map.on('move', onMove);
    return () => {
      map.off('move', onMove);
    };
  }, [map, onMove]);

  const sideBar = {
    backgroundColor: 'rgba(35, 55, 75, 0.9)',
    color: '#fff',
    padding: '6px 12px',
    fontFamily: 'monospace',
    zIndex: 1,
    position: 'absolute',
    top: 0,
    left: 60,
    margin: '12px',
    borderRadius: '4px',
  };

  return (
    <div style={sideBar}>
      Longitude: {position.lng.toFixed(4)} | Latitude: {position.lat.toFixed(4)}
    </div>
  );
};

export default Position;
