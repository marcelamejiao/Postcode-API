package io.nology.postcodeAPI;
import io.nology.postcodeAPI.suburb.Suburb;
import io.nology.postcodeAPI.suburb.SuburbCreateDTO;
import io.nology.postcodeAPI.suburb.SuburbRepository;
import io.nology.postcodeAPI.suburb.SuburbService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class SuburbServiceTest {

   @Mock
   private SuburbRepository suburbRepository;

   @Mock
   private ModelMapper modelMapper;

   @InjectMocks
   private SuburbService underTest;

   @Test
   void getAll_ReturnsAllData(){
      underTest.getAll();
      Mockito.verify(suburbRepository).findAll();
   }

   @Test
   void createSuburb_ValidSuburb_AddsSuburbsToDB() {

      // Create a DTO
      SuburbCreateDTO dto = new SuburbCreateDTO
              ("Suburb name", "Suburb postcode");

      // Create a suburb
      Suburb suburb = new Suburb
              ("Suburb name", "Suburb postcode");

      // Mock mapper
      BDDMockito.given(modelMapper.map(dto, Suburb.class)).willReturn(suburb);

      this.underTest.createSuburb(dto);

      //check that the repository method was called with the correct argument
      ArgumentCaptor<Suburb> suburbArgument = ArgumentCaptor.forClass(Suburb.class);

      Mockito.verify(suburbRepository).save(suburbArgument.capture());

      // check if what save was called with is the same as my suburb
      assertEquals(suburb, suburbArgument.getValue());
   }

   @Test
   void getAllByPostcode_ReturnsAllData(){
      underTest.getAllByPostcode("postcode");
      Mockito.verify(suburbRepository).findByPostcode("postcode");
   }

   @Test
   void getAllByName_ReturnsAllData(){
      underTest.getAllByName("suburb name");
      Mockito.verify(suburbRepository).findByName("suburb name");
   }
}





