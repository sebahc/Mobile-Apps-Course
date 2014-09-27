//
//  ViewController.h
//  GeoLocal
//
//  Created by sebahc on 9/18/14.
//  Copyright (c) 2014 Sebastian J Herrera Cano. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <MapKit/MapKit.h>

@interface ViewController : UIViewController <MKMapViewDelegate>
@property (weak, nonatomic) IBOutlet MKMapView *mapView;

@end
