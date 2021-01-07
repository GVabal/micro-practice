import {Thing} from './Thing';

export interface Order {
  id: number;
  customer: string;
  isShipped: boolean;
  things: Thing[];
}
