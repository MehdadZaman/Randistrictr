import React from 'react';
import { Heading, Stack } from '@chakra-ui/react';
import DistrictingCard from './DistrictingCard';

function DistrictingCardList({ cards, onSelect }) {
  return (
    <Stack spacing={8}>
      <Heading size='md'>{cards.length} redistrictings generated</Heading>
      {cards.map((card) => (
        <DistrictingCard key={card.title} card={card} onSelect={onSelect} />
      ))}
    </Stack>
  );
}

export default DistrictingCardList;
