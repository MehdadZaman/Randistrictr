import React, { useCallback } from 'react';
import { Select } from '@chakra-ui/react';
import states from '../constants/states';
import { bounds } from '../constants/map';

const StateSelect = ({ map, selectedState, onSelect }) => {
  const handleStateSelect = useCallback(
    (stateName) => {
      const state = states.find((state) => state.name === stateName);
      console.log('stateName', stateName);
      console.log('state', state);
      onSelect(stateName);
      if (state) {
        map.fitBounds(state.bounds);
      } else {
        map.fitBounds(bounds);
      }
    },
    [map]
  );

  return (
    <Select
      placeholder='Select state'
      value={selectedState}
      onChange={(e) => handleStateSelect(e.target.value)}
    >
      {states.map((state) => (
        <option key={state.name} value={state.name}>
          {state.name}
        </option>
      ))}
    </Select>
  );
};

export default StateSelect;
