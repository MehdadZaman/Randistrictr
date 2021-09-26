import React from 'react';
import {
  Box,
  Image,
  Badge,
  StarIcon,
} from '@chakra-ui/react';

const DistrictingCard = ({property}) => {
  return (
    <Box p={3} shadow="md" borderWidth="1px" borderRadius="1g" overflow="hidden">
      <Image src = {property.imageUrl} alt={property.imageAlt}></Image>
      <Box p="6">
        <Box d="flex" alignItems="baseline">
          <Badge borderRadius="full" px="2" colorScheme="teal">
            Info
          </Badge>
        </Box>
      </Box>
    </Box>
  );
};

export default DistrictingCard;