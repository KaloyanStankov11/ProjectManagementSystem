import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./pages/login/login.component";
import {TasksComponent} from "./pages/tasks/tasks.component";
import {HomeComponent} from "./pages/home/home.component";
import {TasksResolver} from "./resolver/TasksResolver";
import {LoggedWork} from "./model/LoggedWork";
import {LoggedWorkComponent} from "./pages/logged-work/logged-work.component";
import {WorkersComponent} from "./pages/workers/workers.component";
import {ManageProjectsComponent} from "./pages/manage-projects/manage-projects.component";
import {TaskOverviewComponent} from "./pages/tasks/task-overview/task-overview.component";
import {CreateTaskComponent} from "./pages/tasks/create-task/create-task.component";
import {UsersResolver} from "./resolver/UsersResolver";
import {ProjectsResolver} from "./resolver/ProjectsResolver";
import {LoggedWorkResolver} from "./resolver/LoggedWorkResolver";

const routes: Routes = [{
  path: '',
  redirectTo: 'login',
  pathMatch: 'full',
},
  {path: 'login', component: LoginComponent},
  {path: 'tasks', component: TasksComponent, resolve: { tasks: TasksResolver }},
  {path: 'home', component: HomeComponent},
  {path: 'logged', component: LoggedWorkComponent, resolve: { tasks: TasksResolver, logged: LoggedWorkResolver }},
  {path: 'workers', component: WorkersComponent},
  {path: 'manage-projects', component: ManageProjectsComponent},
  {path: 'task-overview', component: TaskOverviewComponent},
  {path: 'create-task', component: CreateTaskComponent, resolve: {users: UsersResolver, projects: ProjectsResolver}},
  {path: 'edit-task', component: CreateTaskComponent, resolve: {users: UsersResolver, projects: ProjectsResolver}}
  // {path: 'add-worker', component: AddWorkerComponent},
  // {path: 'edit-worker', component: EditWorkerComponent},
  // {path: 'projects', component: ProjectComponent, resolve: {projects: ProjectResolver}},
  // {path: 'logged-time', component: HomeComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {
    useHash: false,
    anchorScrolling: "enabled",
    onSameUrlNavigation: 'reload'
  })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
