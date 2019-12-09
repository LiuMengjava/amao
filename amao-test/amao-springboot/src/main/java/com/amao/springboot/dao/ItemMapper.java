package com.amao.springboot.dao;

import com.amao.springboot.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemMapper extends JpaRepository<Item,Long> {
}
