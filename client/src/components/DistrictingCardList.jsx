import React from 'react';
import { Heading, Stack } from '@chakra-ui/react';
import DistrictingCard from './DistrictingCard';

function DistrictingCardList({ cards, popMeasure, onSelect, loading }) {
  return (
    <Stack spacing={8}>
      {cards.map((card) => (
        <DistrictingCard
          key={card.title}
          popMeasure={popMeasure}
          card={card}
          onSelect={onSelect}
          loading={loading}
        />
      ))}
    </Stack>
  );
}

export default DistrictingCardList;
