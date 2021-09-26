import React from 'react';
import { Stack, VStack, Box, Heading, Text } from "@chakra-ui/react"
import DistrictingCard from './DistrictingCard';


function Feature({ title, desc, ...rest }) {
    return (
      <Box p={5} shadow="md" borderWidth="1px" {...rest}>
        <Heading fontSize="xl">{title}</Heading>
        <Text mt={4}>{desc}</Text>
      </Box>
    )
  }
  
function DistrictingCardList() {
    const props = {
        imageUrl: "https://filipinotimes.net/wp-content/uploads/2019/08/moth-balls.jpg",
        imageAlt: "Maryland",
        title: "Random Districting 1",
        description: "This districting minimized the number of majority minority districts.",
        congressionalDistricts: 8,
        votingDistricts: "8,654",
        minorityMajorityDistrict: 3,
        threshold: 50,
        maxPopulationRange: 137429,
        populationScore: 86,
        efficiencyGapMeasure: 0.44,
        polsbyPopperScore: 0.42,
      };
    return (
        <Stack spacing={8}>
        <DistrictingCard property={props}/>
        <Feature
            title="Kaiwen"
            desc="The future can be even brighter but a goal without a plan is just a wish"
        />
        <Feature
            title="Academy"
            desc="You deserve good things. With a whooping 10-15% interest rate per annum, grow your savings on your own terms with our completely automated process"
        />
        </Stack>
    );
};
  
export default DistrictingCardList;