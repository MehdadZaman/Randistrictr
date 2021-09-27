import React from 'react';
import DistrictingCardList from './DistrictingCardList';

const DistrictingPreview = ({ cards, onSelect }) => {
  return <DistrictingCardList cards={cards} onSelect={onSelect} />;
};

export default DistrictingPreview;
