import {Project} from "./Project";
import {LoggedWork} from "./LoggedWork";

export class AppUser{
  username: string;
  email: string | null;
  password: string;
  phoneNumber: string | null;
  userRole: UserRole | null;
  managedProjects: Project[] | null;
  workingProjects: Project[] | null;
  loggedWork: LoggedWork[] | null;


  constructor(username: string, email: string | null, password: string, phoneNumber: string | null, userRole: UserRole | null, managedProjects: Project[] | null, workingProjects: Project[] | null, loggedWork: LoggedWork[] | null) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.phoneNumber = phoneNumber;
    this.userRole = userRole;
    this.managedProjects = managedProjects;
    this.workingProjects = workingProjects;
    this.loggedWork = loggedWork;
  }
}

export class UserRole{
  roleName: string

  constructor(roleName: string) {
    this.roleName = roleName;
  }
}

export class RegisterUserRequest {
  userInfo: AppUser;
  manager: boolean;

  constructor(userInfo: AppUser, isManager: boolean) {
    this.userInfo = userInfo;
    this.manager = isManager;
  }
}
