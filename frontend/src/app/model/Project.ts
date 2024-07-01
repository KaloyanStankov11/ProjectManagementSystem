import {AppUser} from "./AppUser";
import {Task} from "./Task";

export class Project{
  projectName: string;
  projectManager: AppUser;
  workers: AppUser[];
  tasks: Task[];

  constructor(projectName: string, projectManager: AppUser, workers: AppUser[], tasks: Task[]) {
    this.projectName = projectName;
    this.projectManager = projectManager;
    this.workers = workers;
    this.tasks = tasks;
  }
}
