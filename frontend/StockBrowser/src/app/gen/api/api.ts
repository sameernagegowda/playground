export * from './stock.service';
import { StockService } from './stock.service';
export * from './user.service';
import { UserService } from './user.service';
export const APIS = [StockService, UserService];
