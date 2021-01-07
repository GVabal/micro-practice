import {Thing} from './Thing';

export interface OrderNewRequest {
  customer: string;
  things: Thing[];
}
