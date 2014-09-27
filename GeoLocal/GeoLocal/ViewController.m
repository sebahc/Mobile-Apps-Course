//
//  ViewController.m
//  GeoLocal
//
//  Created by sebahc on 9/18/14.
//  Copyright (c) 2014 Sebastian J Herrera Cano. All rights reserved.
//

#import "ViewController.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}


- (void)mapView:(MKMapView *)mapView didUpdateUserLocation:(MKUserLocation *)userLocation{
    // The following lines of code instructs the map view to zoom into a region that is 800 by 800 meters around the user’s location.
    MKCoordinateRegion region = MKCoordinateRegionMakeWithDistance(userLocation.coordinate, 800, 800);
    [self.mapView setRegion:[self.mapView regionThatFits:region] animated:YES];
    
    // Add an annotation
    MKPointAnnotation *point = [[MKPointAnnotation alloc] init];
    point.coordinate = userLocation.coordinate;
    point.title = @"Curso de IOS";
    point.subtitle = @"Estoy aqui!!!";
    
    [self.mapView addAnnotation:point];
    
}

@end
