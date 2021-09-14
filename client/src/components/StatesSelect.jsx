import React from 'react';
import { Select } from '@chakra-ui/react';
import states from '../constants/states';

const StatesSelect = ({ onChange }) => {
  return (
    <Select
      placeholder='Select state'
      onChange={(e) => onChange(e.target.value)}
    >
      {states.map((state) => (
        <option value={state.name}>{state.name}</option>
      ))}
    </Select>
  );
};

export default StatesSelect;
