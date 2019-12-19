import { Component } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Angular 6 Application';
  message:string = 'default';

  rootPath: string = environment.serverUrl + environment.contextPath;
  msgUrl = this.rootPath + '/api/hi'
  
  constructor(private http:HttpClient){
    http.get(this.msgUrl).subscribe((response:DataResponse) => {
      let result = response;
      this.message = result.message;
    });
  }
  
}

export class DataResponse{
  message  : string;  
}
