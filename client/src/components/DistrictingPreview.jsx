import React from 'react';
import DistrictingCardList from './DistrictingCardList';

const DistrictingPreview = ({ cards, popMeasure, onSelect }) => {
  return (
    <DistrictingCardList
      cards={cards}
      popMeasure={popMeasure}
      onSelect={onSelect}
    />
  );
};

export default DistrictingPreview;
