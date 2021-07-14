package com.crud.tasks.controller;

import com.crud.tasks.domain.CreatedTrelloCard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.trello.client.TrelloClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/v1/trello")
@RequiredArgsConstructor
public class TrelloController {

    private final TrelloClient trelloClient;

    @GetMapping("getTrelloBoards")
    public void getTrelloBoards() {

        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();

        trelloBoards.stream()
                .filter(p-> Objects.nonNull(p.getId()) && Objects.nonNull(p.getName()))
                .filter(p -> p.getName().contains("Kodilla"))
                .forEach(trelloBoardDto -> {
                    System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName());
                });
    }

//    @GetMapping("getTrelloBoards")
//    public void getTrelloBoards() {
//        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();
//        trelloBoards.forEach(trelloBoardDto -> {
//            System.out.println(trelloBoardDto.getId() + " " + trelloBoardsDto.getName());
//
//            System.out.println("This board contains lists: ");
//
//            trelloBoardsDto.getLists().forEach(trelloList -> {
//                System.out.println(trelloList.getName() + " - " + trelloList.getI() + " - " + trelloList.isClosed()
//                );
//            });
//
//        });
//    }
}