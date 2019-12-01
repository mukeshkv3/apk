import { Customer } from "./customer";
import { Shop } from "./shop";
import { Food } from "./food";
import { Addon } from "./addon";

export class Order {
    oid: string;
    customer: Customer;
    shop: Shop;
    orderstatus: string;
    total: number;
}
