import React from 'react';
import {
  Box,
  Text,
  Image,
  Button,
  ButtonGroup,
} from '@chakra-ui/react';

const DistrictingCard = ({property}) => {
  return (
    <Box shadow="md" borderWidth="1px" borderRadius="1g" overflow="hidden">
      <Image src = {property.imageUrl} alt={property.imageAlt}></Image>
      <Box p={2}>
      <Box
        color="gray.500"
        fontWeight="semibold"
        letterSpacing="wide"
        fontSize="xs"
        textTransform="uppercase"
        ml="1"
      >
        {property.congressionalDistricts} Congressional &bull; {property.votingDistricts}  Voting
      </Box>
        <Box
            mt="1"
            fontWeight="semibold"
            as="h4"
            lineHeight="tight"
            isTruncated="true"
          >
          {property.title}
        </Box>
        <Text size="sm">
          {property.description}
        </Text>
        <Box 
          pt = '10'
          border='0'
          d='flex'
          alignItems='center'
          justifyContent='flex-end'
          pb={2}
        >
          
          <ButtonGroup size='sm'>
            <Button colorScheme='green'>
              Use!
            </Button>
          </ButtonGroup>
        </Box>
      </Box>
    </Box>
  );
};

export default DistrictingCard;