package pl.coderslab.beskidyenduranceproject.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.beskidyenduranceproject.entity.Message;
import pl.coderslab.beskidyenduranceproject.repository.MessageRepository;

public class MessageConverter implements Converter<String, Message> {

    @Autowired
    MessageRepository messageRepository;

    @Override
    public Message convert(String s) {
        Message message = messageRepository.getOne(Long.parseLong(s));
        return message;
    }
}
