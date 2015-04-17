package com.springcamp.integration.exercise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

/**
 * @author wglee21g@gmail.com
 */
@Service
public class MessageRouterServiceImpl implements MessageRouterService {
	@Autowired
	private MessageChannel jmsOutChannel;

	@Autowired
	private MessageChannel nodejsOutChannel;

	@Override
	public void sendAtJms(String messageContent) {
		Message<String> message = MessageBuilder.withPayload(messageContent).build();
		jmsOutChannel.send(message);
	}

	@Override
	public void sendAtNodejs(String messageContent) {
		Message<String> message = MessageBuilder.withPayload(messageContent).build();
		nodejsOutChannel.send(message);
	}
}