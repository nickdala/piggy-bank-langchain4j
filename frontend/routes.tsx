import CustomersView from './views/customers/CustomersView';
import MainLayout from 'Frontend/views/MainLayout.js';
import { lazy } from 'react';
import { createBrowserRouter, RouteObject } from 'react-router-dom';

const AboutView = lazy(async () => import('Frontend/views/about/AboutView.js'));
const ChatView = lazy(async () => import('Frontend/views/chat/ChatView.js'));

export const routes = [
  {
    element: <MainLayout />,
    handle: { title: 'Piggy Bank' },
    children: [
      { path: '/', element: <CustomersView />, handle: { title: 'Customers' } },
      { path: '/about', element: <AboutView />, handle: { title: 'About' } },
      { path: '/chat', element: <ChatView />, handle: { title: 'Chat' } },

    ],
  },
] as RouteObject[];

export default createBrowserRouter(routes);
