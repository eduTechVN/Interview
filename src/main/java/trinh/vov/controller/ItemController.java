package trinh.vov.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trinh.vov.model.dto.request.item.ItemReDto;
import trinh.vov.model.dto.response.item.ItemResDto;
import trinh.vov.service.item.ItemService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class ItemController {
    private final ItemService itemService;

    @Operation(description = "Endpoint api that create fruit. there are 2 value for unit ML & G")
    @PostMapping("/fruits")
    public ResponseEntity<HttpStatus> createFruit(@RequestBody @Valid List<ItemReDto> item){
        itemService.addItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(description = "Endpoint api that update fruit. there are 2 value for unit ML & G")
    @PutMapping("/fruits/{id}")
    public ResponseEntity<HttpStatus> editFruit(
            @PathVariable("id") String itemId,
            @RequestBody @Valid ItemReDto item){
        itemService.updateItem(itemId , item);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(description = "Get all fruits.")
    @GetMapping("/fruits")
    public ResponseEntity<List<ItemResDto>> getFruits(){
        return ResponseEntity.ok(itemService.getItems());
    }
}
