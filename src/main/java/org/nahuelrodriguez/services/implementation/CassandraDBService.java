package org.nahuelrodriguez.services.implementation;

import org.nahuelrodriguez.daos.Repository;
import org.nahuelrodriguez.dtos.TodoItemDTO;
import org.nahuelrodriguez.entities.TodoItem;
import org.nahuelrodriguez.mappers.TodoItemDTOMapper;
import org.nahuelrodriguez.mappers.TodoItemMapper;
import org.nahuelrodriguez.services.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CassandraDBService implements TodoListService {
    private final TodoItemMapper toEntityMapper;
    private final TodoItemDTOMapper toDtoMapper;
    private final Repository repository;

    @Autowired
    public CassandraDBService(final Repository repository) {
        this.repository = repository;
        this.toEntityMapper = new TodoItemMapper();
        this.toDtoMapper = new TodoItemDTOMapper();
    }

    public void addNewTodoItem(final TodoItemDTO dto) {
        final TodoItem entity = toEntityMapper.from(dto);
        entity.setCreatedDatetime(Instant.now());

        repository.save(entity);
    }

    public void addNewTodoItems(final Collection<TodoItemDTO> dtos) {
        final List<TodoItem> entities = dtos.stream()
                .map(toEntityMapper::from)
                .collect(Collectors.toList());
        repository.saveAll(entities);
    }

    public void deleteTodoItem(final Long id) {
        repository.deleteById(id);
    }

    public void deleteAllTodoItems() {
        repository.deleteAll();
    }

    public Page<TodoItemDTO> getAllTodoItems() {
        final List<TodoItemDTO> dtos = new ArrayList<>();
        repository.findAll().forEach(entity -> dtos.add(toDtoMapper.from(entity)));
        return new PageImpl<>(dtos);
    }

    public void updateTodoItem(final TodoItemDTO dto) {
        final Optional<TodoItem> entity = repository.findById(dto.getId());
        entity.ifPresent(e -> {
            e.setDescription(dto.getDescription());
            repository.save(e);
        });
    }
}