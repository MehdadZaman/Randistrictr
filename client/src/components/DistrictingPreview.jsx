import { useRef, React } from 'react';
import {
  Box,
  Image,
  Text,
  Popover,
  Button,
  ButtonGroup,
  PopoverTrigger,
  PopoverContent,
  PopoverHeader,
  PopoverBody,
  PopoverFooter,
  PopoverArrow,
  PopoverCloseButton,
} from '@chakra-ui/react';

const DistrictingPreview = ({ onSelect }) => {
  const initialFocusRef = useRef();

  return (
    <Popover
      initialFocusRef={initialFocusRef}
      placement='right'
      offset={[5, 0]} //i hate styling
      trigger='hover'
    >
      <PopoverTrigger>
        <Box d='flex' justifyContent='center' w='95%'>
          <Image
            boxSize='250px'
            objectFit='contain'
            src='https://filipinotimes.net/wp-content/uploads/2019/08/moth-balls.jpg'
            alt='Picture of Moth Balls'
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
        {/*<PopoverArrow bg="rgba(35, 55, 75, 0.8)"/>*/}
        <PopoverCloseButton />
        <PopoverBody fontSize='sm'>
          <Text>3 Majority Minority districts at 50% threshold</Text>
          <Text>Maximum Population Range: 137249</Text>
          <Text>Mattingly Population Score: 86</Text>
          <Text>Efficiency Gap Measure: 0.44</Text>
          <Text>Polsby Popper Score: 0.42</Text>
        </PopoverBody>
        <PopoverFooter
          border='0'
          d='flex'
          alignItems='center'
          justifyContent='space-between'
          pb={4}
        >
          <Box fontSize='sm'> Display on Map? </Box>
          <ButtonGroup size='sm'>
            <Button colorScheme='red' ref={initialFocusRef}>
              Cancel
            </Button>
            <Button colorScheme='green' onClick={onSelect}>
              Use!
            </Button>
          </ButtonGroup>
        </PopoverFooter>
      </PopoverContent>
    </Popover>
  );
};

export default DistrictingPreview;
