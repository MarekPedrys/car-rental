package pl.jcommerce.carrental.car

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import pl.jcommerce.carrental.CarRentalApplication
import pl.jcommerce.carrental.car.entity.Body
import pl.jcommerce.carrental.car.entity.Car
import pl.jcommerce.carrental.car.entity.Color
import pl.jcommerce.carrental.car.entity.Fuel
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@AutoConfigureMockMvc
@SpringBootTest(classes = [CarRentalApplication])
class CarControllerSpecification extends Specification {

    @Autowired
    private MockMvc mockMvc

    @Autowired
    CarRepository carRepository

    Car carTest1 = new Car("brandTest1", "modelTest1", 2011, Body.HATCHBACK, Fuel.PETROL,
            Color.RED, 5, 4, false, true)
    Car carTest2 = new Car("brandTest2", "modelTest2", 2012, Body.HATCHBACK, Fuel.PETROL,
            Color.RED, 2, 2, false, true)

    Long carTest1Id

    ObjectMapper objectMapper = new ObjectMapper()
    def carTestJson1 = objectMapper.writeValueAsString(carTest1)
    def carTestJson2 = objectMapper.writeValueAsString(carTest2)

    void setup() {
        carRepository.deleteAll()
        carRepository.save(carTest1)
        carTest1Id = carRepository.findByBrand("brandTest1").get(0).getId()
    }

    def "should get status 200 when it gets all cars"() {
        expect:
        mockMvc.perform(get("/api/cars")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.employeeId").exists());
//                .andExpect(content().string(containsString("Hello, Mock")));
    }

    def "should get status 200 when it gets a single car by correct id"() {
        expect:
        mockMvc.perform(get("/api/cars/" + carTest1Id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
    }

    def "should get status 404 when it gets a single car by incorrect id"() {
        expect:
        mockMvc.perform(get("/api/cars/" + carTest1Id + 1)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
    }

    def "should get status 201 when it adds a car"() {
        expect:
        mockMvc.perform(post("/api/cars")
                .content(carTestJson1)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())

    }

    def "should get status 200 when it updates a car"() {
        expect:
        mockMvc.perform(put("/api/cars/" + carTest1Id)
                .content(carTestJson2)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
    }

    def "should get status 202 when deletes a car"() {
        expect:
        mockMvc.perform(delete("/api/cars/" + carTest1Id))
                .andExpect(status().isAccepted())

    }

    def "za Danielem should add a car"() {
        given:
        mockMvc.perform(post("/api/cars")
                .content(carTestJson2)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))

        expect:
        !carRepository.findByBrand("brandTest2").isEmpty()
    }

    def "za Danielem should modify a car by id"() {
        when:
        mockMvc.perform(put("/api/cars/" + carTest1Id)
                .content(carTestJson2)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))

        then:
        carRepository.findById(carTest1Id).get().getBrand() == "brandTest2"
    }

    def "za Danielem should delete a car by id"() {
        when:
        mockMvc.perform(delete("/api/cars/" + carTest1Id))

        then:
        carRepository.findAll().isEmpty()
    }

}


