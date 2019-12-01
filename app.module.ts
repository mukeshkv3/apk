import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { AddcustomerComponent } from './addcustomer/addcustomer.component';
import { CustomerService } from './customer.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { CustomerlistComponent } from './customerlist/customerlist.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { ShopComponent } from './shop/shop.component';
import { LocationComponent } from './location/location.component';
import { AddshopComponent } from './addshop/addshop.component';
import { AddlocationComponent } from './addlocation/addlocation.component';
import { ListshopComponent } from './listshop/listshop.component';
import { ListlocationComponent } from './listlocation/listlocation.component';
import { AdminComponent } from './admin/admin.component';
import { OrderComponent } from './order/order.component';
import { AddadminComponent } from './addadmin/addadmin.component';
import { AdminlistComponent } from './adminlist/adminlist.component';
import { OrderlistComponent } from './orderlist/orderlist.component';
import { AddaddonComponent } from './addaddon/addaddon.component';
import { ListaddonComponent } from './listaddon/listaddon.component';
import { FoodadminComponent } from './foodadmin/foodadmin.component';
import { AddfoodComponent } from './addfood/addfood.component';
import { ListfoodComponent } from './listfood/listfood.component';
import { CustomerMenuComponent } from './customer-menu/customer-menu.component';
import { CustomerMenuFoodComponent } from './customer-menu-food/customer-menu-food.component';
import { PaymentComponent } from './payment/payment.component';
import { VieworderComponent } from './vieworder/vieworder.component';
import { StatusadminComponent } from './statusadmin/statusadmin.component';

const appRouter: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'addcustomer', component: AddcustomerComponent },
  { path: 'adminLogin', component: AdminLoginComponent },
  {
    path: 'shopAdmin', component: ShopComponent,
    children: [
      {
        path: 'shopList', component: ListshopComponent
      },
      {
        path: 'addShop', component: AddshopComponent
      },
      {
        path: 'locationList', component: ListlocationComponent
      },
      {
        path: 'addLocation', component: AddlocationComponent
      }
    ]
  },
  {
    path: 'foodAdmin', component: FoodadminComponent,
    children: [
      {
        path: 'foodList', component: ListfoodComponent
      },
      {
        path: 'addFood', component: AddfoodComponent
      },
      {
        path: 'addonList', component: ListaddonComponent
      },
      {
        path: 'addaddon', component: AddaddonComponent
      }
    ]
  },
  {
    path: 'statusAdmin', component: StatusadminComponent,
    children: [
      {
        path: 'adminList', component: AdminlistComponent
      },
      {
        path: 'addAdmin', component: AddadminComponent
      },
      {
        path: 'orderList', component: OrderlistComponent
      }
    ]
  },
  { path: 'login', component: LoginComponent },
  { path: 'customerMenu', component: CustomerMenuComponent },
  { path: 'foodMenu', component: CustomerMenuFoodComponent },
  { path: 'order', component: OrderComponent },
  { path: 'payment', component: PaymentComponent },
  { path: 'viewOrder', component: VieworderComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: '**', component: PagenotfoundComponent }
];
@NgModule({
  declarations: [
    AppComponent,
    AddcustomerComponent,
    LoginComponent,
    CustomerlistComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    PagenotfoundComponent,
    AdminLoginComponent,
    ShopComponent,
    LocationComponent,
    AddshopComponent,
    AddlocationComponent,
    ListshopComponent,
    ListlocationComponent,
    AdminComponent,
    OrderComponent,
    AddadminComponent,
    AdminlistComponent,
    OrderlistComponent,
    AddaddonComponent,
    ListaddonComponent,
    FoodadminComponent,
    AddfoodComponent,
    ListfoodComponent,
    CustomerMenuComponent,
    CustomerMenuFoodComponent,
    PaymentComponent,
    VieworderComponent,
    StatusadminComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRouter),
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [CustomerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
