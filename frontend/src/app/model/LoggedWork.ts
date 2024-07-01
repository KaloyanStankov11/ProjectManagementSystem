import {AppUser} from "./AppUser";
import {Project} from "./Project";
import {Task} from "./Task";

export class LoggedWork{
  worker: AppUser;
  project: Project;
  task: Task;
  loggedTimeNumber: number;
  loggedTimeUnit: string;
  date: Date;


  constructor(worker: AppUser, project: Project, task: Task, loggedTimeNumber: number, loggedTimeUnit: string, date: Date) {
    this.worker = worker;
    this.project = project;
    this.task = task;
    this.loggedTimeNumber = loggedTimeNumber;
    this.loggedTimeUnit = loggedTimeUnit;
    this.date = date;
  }
}
