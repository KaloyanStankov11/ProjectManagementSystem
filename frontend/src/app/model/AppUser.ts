import {Project} from "./Project";
import {LoggedWork} from "./LoggedWork";

export class AppUser{
  username: string;
  email: string | null;
  password: string;
  phoneNumber: string | null;
  userRole: UserRole | null;
  loggedWork: LoggedWork[] | null;


  constructor(username: string, email: string | null, password: string, phoneNumber: string | null, userRole: UserRole | null, loggedWork: LoggedWork[] | null) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.phoneNumber = phoneNumber;
    this.userRole = userRole;
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
