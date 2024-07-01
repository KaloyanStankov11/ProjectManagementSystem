export class LoginResponse {
  username: string;
  authorities: string[]

  constructor(username: string, authorities: string[]) {
    this.username = username;
    this.authorities = authorities;
  }
}
