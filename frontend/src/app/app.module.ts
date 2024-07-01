import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { TasksComponent } from './pages/tasks/tasks.component';
import { TaskOverviewComponent } from './pages/tasks/task-overview/task-overview.component';
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatListModule} from "@angular/material/list";
import {MatButtonToggleModule} from "@angular/material/button-toggle";
import {MatSelectModule} from "@angular/material/select";
import { LoginComponent } from './pages/login/login.component';
import { MenuComponent } from './pages/menu/menu.component';
import {MatCardModule} from "@angular/material/card";
import {ReactiveFormsModule} from "@angular/forms";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {BasicHttpInterceptorService} from "./service/basic-http-interceptor.service";
import {MatInputModule} from "@angular/material/input";
import {MatFormFieldModule} from "@angular/material/form-field";
import { HomeComponent } from './pages/home/home.component';
import { HeaderComponent } from './pages/header/header.component';
import {MatIconModule} from "@angular/material/icon";
import {MatTooltip, MatTooltipModule} from "@angular/material/tooltip";
import {MatMenuModule} from "@angular/material/menu";
import {MatButtonModule} from "@angular/material/button";
import {MatChipsModule} from "@angular/material/chips";
import {MatTableModule} from "@angular/material/table";
import { LoggedWorkComponent } from './pages/logged-work/logged-work.component';
import { WorkersComponent } from './pages/workers/workers.component';
import { ManageProjectsComponent } from './pages/manage-projects/manage-projects.component';
import { CreateTaskComponent } from './pages/tasks/create-task/create-task.component';
import { AddLogModalComponent } from './pages/logged-work/add-log-modal/add-log-modal.component';
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatDialogModule, MatDialogRef} from "@angular/material/dialog";
import {MatNativeDateModule} from "@angular/material/core";
import { AddWorkerComponent } from './pages/workers/add-worker/add-worker.component';
import {MatCheckboxModule} from "@angular/material/checkbox";

@NgModule({
  declarations: [
    AppComponent,
    TasksComponent,
    TaskOverviewComponent,
    LoginComponent,
    MenuComponent,
    HomeComponent,
    HeaderComponent,
    LoggedWorkComponent,
    WorkersComponent,
    ManageProjectsComponent,
    CreateTaskComponent,
    AddLogModalComponent,
    AddWorkerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatListModule,
    MatButtonToggleModule,
    MatSelectModule,
    MatCardModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    MatTooltipModule,
    MatMenuModule,
    MatButtonModule,
    MatChipsModule,
    MatTableModule,
    MatDatepickerModule,
    MatDialogModule,
    MatNativeDateModule,
    MatCheckboxModule
  ],
  providers: [{provide: HTTP_INTERCEPTORS, useClass: BasicHttpInterceptorService, multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
