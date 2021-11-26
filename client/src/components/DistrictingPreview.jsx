import React from 'react';
import DistrictingCardList from './DistrictingCardList';

const DistrictingPreview = ({ cards, popMeasure, onSelect, loading }) => {
  return (
    <DistrictingCardList
      cards={cards}
      popMeasure={popMeasure}
      onSelect={onSelect}
      loading={loading}
    />
  );
};

export default DistrictingPreview;
