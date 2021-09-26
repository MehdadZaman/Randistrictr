import React from 'react';
import { Stack, VStack, Box, Heading, Text } from "@chakra-ui/react"


function Feature({ title, desc, ...rest }) {
    return (
      <Box p={5} shadow="md" borderWidth="1px" {...rest}>
        <Heading fontSize="xl">{title}</Heading>
        <Text mt={4}>{desc}</Text>
      </Box>
    )
  }
  
function DistrictingCardList() {
return (
    <Stack spacing={8}>
    <Feature
        title="Kaiwen"
        desc="The future can be even brighter but a goal without a plan is just a wish"
    />
    <Feature
        title="Academy"
        desc="You deserve good things. With a whooping 10-15% interest rate per annum, grow your savings on your own terms with our completely automated process"
    />
    </Stack>
)
}
  
export default DistrictingCardList;