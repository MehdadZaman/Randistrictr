import React, { useRef } from 'react';
import {
  Box,
  Text,
  Image,
  Popover,
  Button,
  ButtonGroup,
  PopoverTrigger,
  PopoverContent,
  PopoverHeader,
  PopoverBody,
  PopoverCloseButton,
} from '@chakra-ui/react';

const DistrictingCardPopover = ({ card, popMeasure, onSelect }) => {
  const initialFocusRef = useRef();

  return (
    <Popover
      initialFocusRef={initialFocusRef}
      placement='right'
      offset={[5, 0]} //i hate styling
      trigger='hover'
      isOpen={false}
    >
      <PopoverTrigger>
        <Box d='flex' justifyContent='center' w='95%'>
          <DistrictingCard
            property={card}
            popMeasure={popMeasure}
            onSelect={onSelect}
          />
        </Box>
      </PopoverTrigger>
      <PopoverContent
        bg='rgba(35, 55, 75, 0.8)'
        color='white'
        borderColor='rgba(35, 55, 75, 0.8)'
      >
        <PopoverHeader pt={4} fontWeight='bold' border='0'>
          Random Districting 1
        </PopoverHeader>
        <PopoverCloseButton />
        <PopoverBody fontSize='sm'>
          {/* <Text>
            {card.minorityMajorityDistrict} Majority Minority districts at{' '}
            {card.threshold}% threshold
          </Text>
          <Text>Maximum Population Range: {card.maxPopulationRange}</Text> */}
          <Text>Mattingly Population Score: {card.populationScore}</Text>
          <Text>Efficiency Gap Measure: {card.efficiencyGap}</Text>
          {/* <Text>Polsby Popper Score: {card.polsbyPopperScore}</Text> */}
        </PopoverBody>
      </PopoverContent>
    </Popover>
  );
};

const DistrictingCard = ({ property, popMeasure, onSelect }) => {
  const absoluteDifferenceInPopulation =
    property[`${popMeasure.toLowerCase()}AbsoluteDifferenceInPopulation`];
  const efficiencyGap = property[`${popMeasure.toLowerCase()}EfficiencyGap`];
  const numOpportunityDistricts =
    property[`${popMeasure.toLowerCase()}NumOpportunityDistricts`];
  const objectiveFunctionScore =
    property[`${popMeasure.toLowerCase()}ObjectiveFunctionScore`];
  const populationScore =
    property[`${popMeasure.toLowerCase()}PopulationScore`];

  return (
    <Box
      shadow='md'
      borderWidth='1px'
      borderRadius='1g'
      overflow='hidden'
      w='100%'
    >
      <Image src={property.imageUrl} alt={property.imageAlt}></Image>
      <Text>
        Absolute Difference in Population: {absoluteDifferenceInPopulation}
      </Text>
      <Text>Number of Opportunity Districts: {numOpportunityDistricts}</Text>
      <Text>Mattingly Population Score: {populationScore}</Text>
      <Text>Efficiency Gap Measure: {efficiencyGap}</Text>
      <Text>Objective Function Score: {objectiveFunctionScore}</Text>
      <Box p={2}>
        <Box
          color='gray.500'
          fontWeight='semibold'
          letterSpacing='wide'
          fontSize='xs'
          textTransform='uppercase'
          ml='1'
        >
          {property.numCongressionalDistricts} Congressional Districts &bull;{' '}
          {/* {property.votingDistricts.toLocaleString()} Voting */}
        </Box>
        <Box
          mt='1'
          fontWeight='semibold'
          as='h4'
          lineHeight='tight'
          isTruncated='true'
        >
          Districting {property.redistrictNumber}
        </Box>
        <Text size='sm'>{property.description}</Text>
        <Box
          pt='10'
          border='0'
          d='flex'
          alignItems='center'
          justifyContent='flex-end'
          pb={2}
        >
          <ButtonGroup size='sm'>
            <Button
              colorScheme='green'
              onClick={() => onSelect(property.redistrictNumber)}
            >
              Use!
            </Button>
          </ButtonGroup>
        </Box>
      </Box>
    </Box>
  );
};

export default DistrictingCardPopover;
