import {AppUser} from "./AppUser";
import {Project} from "./Project";
import {Task} from "./Task";
import {TimeMeasure} from "./TimeMeasure";

export class LoggedWork{
  id: number;
  worker: AppUser;
  project: Project;
  task: Task;
  loggedTime: TimeMeasure;
  date: Date;


  constructor(worker: AppUser, project: Project, task: Task, loggedTime: TimeMeasure, date: Date) {
    this.id = 0;
    this.worker = worker;
    this.project = project;
    this.task = task;
    this.loggedTime = loggedTime
    this.date = date;
  }
}

export class LogWorkRequest{
  task: Task;
  loggedTimeNumber: number;
  loggedTimeUnit: string;
  date: Date;

  constructor(task: Task, loggedTimeNumber: number, loggedTimeUnit: string, date: Date) {
    this.task = task;
    this.loggedTimeNumber = loggedTimeNumber;
    this.loggedTimeUnit = loggedTimeUnit;
    this.date = date;
  }
}
