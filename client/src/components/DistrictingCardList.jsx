import React from 'react';
import { Heading, Stack } from '@chakra-ui/react';
import DistrictingCard from './DistrictingCard';

function DistrictingCardList({ cards, popMeasure, onSelect }) {
  return (
    <Stack spacing={8}>
      {cards.map((card) => (
        <DistrictingCard
          key={card.title}
          popMeasure={popMeasure}
          card={card}
          onSelect={onSelect}
        />
      ))}
    </Stack>
  );
}

export default DistrictingCardList;
