import { Button } from '@hilla/react-components/Button.js';
//https://hilla.dev/docs/react/components/message-list
import {MessageList, MessageListItem} from "@hilla/react-components/MessageList";
//https://hilla.dev/docs/react/components/message-input
import { MessageInput } from '@hilla/react-components/MessageInput';
import { Notification } from '@hilla/react-components/Notification.js';
import { TextField } from '@hilla/react-components/TextField.js';
import { ChatService } from 'Frontend/generated/endpoints';
import { useState } from 'react';

export default function ChatView() {
    const [messages, setMessages] = useState<MessageListItem[]>([]);

    function addMessage(message: MessageListItem) {
        setMessages(oldMessages => [...oldMessages, message]);
    }

    async function sayHello(message: string) {
        addMessage({
            text: message,
            userName: 'You'
        });

        //const message = await ChatService.chat(name);
        //addMessage({ userName: 'Bot', text: message });
        addMessage({
            text: "Hello!",
            userName: 'Bot'
        });
    }

    return (
      <div>
        <MessageList items={messages} />
        <MessageInput onSubmit={e => sayHello(e.detail.value)} />
      </div>
    );
}
