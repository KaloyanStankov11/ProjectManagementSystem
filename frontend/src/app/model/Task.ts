import {AppUser} from "./AppUser";
import {Project} from "./Project";
import {TimeMeasure} from "./TimeMeasure";

export class Task{
  id: number
  caption: string;
  description: string;
  assignee: AppUser;
  creationTime: string;
  project: string;
  taskStatus: TaskStatus;
  estimatedTime: TimeMeasure
  creator: string;

  constructor(caption: string, description: string, assignee: AppUser, project: string, taskStatus: TaskStatus, estimationTime: TimeMeasure) {
    this.id = 0;
    this.caption = caption;
    this.description = description;
    this.assignee = assignee;
    this.creationTime = "2000-01-01T00:00:00.000";
    this.project = project;
    this.taskStatus = taskStatus;
    this.estimatedTime = estimationTime;
    this.creator = "";
  }
}

export enum TaskStatus{
  IN_PROGRESS = "IN_PROGRESS", UNASSIGNED = "UNASSIGNED", REJECTED = "REJECTED", DONE = "DONE"
}
