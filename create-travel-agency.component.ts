import { Component } from '@angular/core';
import { TravelAgencyServiceService } from '../travel-agency-service.service';
import { Router } from '@angular/router';
import { TravelAgency } from '../travel-agency';

@Component({
  selector: 'app-create-travel-agency',
  templateUrl: './create-travel-agency.component.html',
  styleUrls: ['./create-travel-agency.component.css']
})
export class CreateTravelAgencyComponent {
  routeService: any;
  constructor(private travelAgencyService: TravelAgencyServiceService,
    private router: Router) { }

    travelAgency :  TravelAgency= new TravelAgency();
    saveTravelAgency(){
      this.travelAgencyService.createAgencyDetails(this.travelAgency).subscribe( (data: any) =>{
        console.log(data);
        this.goToTravelAgencyData();
      },
        (      error: any) => console.log(error));
    }
    goToTravelAgencyData(){
      this.router.navigate(['see-all-agencyDetails']);
    }
    
    onSubmit(){
      console.log(this.travelAgency);
      this.saveTravelAgency();
    }
}

