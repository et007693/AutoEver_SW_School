//
//  Landmark.swift
//  Landmark
//
//  Created by Admin on 8/18/25.
//

import Foundation
import SwiftUI
import CoreLocation

struct Landmark: Hashable, Codable, Identifiable {
    var id: Int
    var name: String
    var city: String
    var park: String
    var state: String
    var description: String
    var isFavorite: Bool
    var isFeatured: Bool
    
    var category: Category
    enum Category: String, CaseIterable, Codable {
        case tower = "Towers"
        case palaces = "Palaces"
        case mountains = "Mountains"
        case temples = "Temples"
    }
    
    private var imageName: String
    var image: Image{ // 즉시 실행 클로저
        Image(imageName) // 이미지 뷰를 반환
    }
    
    private var coordinates: Coordinates
    var location: CLLocationCoordinate2D {
        CLLocationCoordinate2D(
            latitude: coordinates.latitude,
            longitude: coordinates.longitude
        )
    }
    
    struct Coordinates: Hashable, Codable {
        var latitude: Double
        var longitude: Double
    }
}


