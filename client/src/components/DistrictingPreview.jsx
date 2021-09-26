import { useRef, React } from 'react';
import DistrictingCardList from './DistrictingCardList';
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

const DistrictingPreview = () => {
  const initialFocusRef = useRef();

  return (
    // <Popover
    //   initialFocusRef={initialFocusRef}
    //   placement='top-start'
    //   offset={[5, -235]} //i hate styling
    //   matchWidth={true} // does this do anything?
    // >
    //   <PopoverTrigger>
    //     <Box d='flex' justifyContent='center' w='95%'>
    //       <Image
    //         boxSize='250px'
    //         objectFit='contain'
    //         src='https://filipinotimes.net/wp-content/uploads/2019/08/moth-balls.jpg'
    //         alt='Picture of Moth Balls'
    //       />
    //     </Box>
    //   </PopoverTrigger>
    //   <PopoverContent
    //     bg='rgba(35, 55, 75, 0.8)'
    //     color='white'
    //     borderColor='rgba(35, 55, 75, 0.8)'
    //   >
    //     <PopoverHeader pt={4} fontWeight='bold' border='0'>
    //       Random Districting 1
    //     </PopoverHeader>
    //     {/*<PopoverArrow bg="rgba(35, 55, 75, 0.8)"/>*/}
    //     <PopoverCloseButton />
    //     <PopoverBody fontSize='sm'>
    //       <Text>3 Majority Minority districts at 50% threshold</Text>
    //       <Text>Maximum Population Range: 137249</Text>
    //       <Text>Mattingly Population Score: 86</Text>
    //       <Text>Efficiency Gap Measure: 0.44</Text>
    //       <Text>Polsby Popper Score: 0.42</Text>
    //     </PopoverBody>
    //     <PopoverFooter
    //       border='0'
    //       d='flex'
    //       alignItems='center'
    //       justifyContent='space-between'
    //       pb={4}
    //     >
    //       <Box fontSize='sm'> Display on Map? </Box>
    //       <ButtonGroup size='sm'>
    //         <Button colorScheme='blue' ref={initialFocusRef}>
    //           Cancel
    //         </Button>
    //         <Button colorScheme='green'>Use!</Button>
    //       </ButtonGroup>
    //     </PopoverFooter>
    //   </PopoverContent>
    // </Popover>
    <DistrictingCardList/> 
  );
};

export default DistrictingPreview;
