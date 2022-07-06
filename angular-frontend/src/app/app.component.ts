import { Component, OnInit } from '@angular/core';
import { SuperisorService } from './superisor.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [SuperisorService]
})
export class AppComponent implements OnInit {
  title = 'angular-frontend';

  supervisors: any;

  constructor(private superivorService: SuperisorService) {}
  ngOnInit() {
    this.loadSupervisors();
  }

  loadSupervisors() {
    this.superivorService.getSuperisor().subscribe((data: any) => {
      this.supervisors = data;
      console.log(data);
    });

  }



}
