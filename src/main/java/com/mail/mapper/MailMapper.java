package com.mail.mapper;

import com.mail.domain.Mailtemplate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MailMapper {
    String[] getRecipient(@Param("system") String system, @Param("type") String type);

    Mailtemplate getTemplate(@Param("id") int id);
}
