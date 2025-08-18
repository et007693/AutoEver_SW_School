//
//  CircleImage.swift
//  Landmark
//
//  Created by Admin on 8/18/25.
//

import SwiftUI

struct CircleImage: View {
    var body: some View {
        Image("tower")
            .resizable()
            .frame(width: 250, height: 250)
            .clipShape(Circle())
            .overlay(
                Circle().stroke(Color.white, lineWidth: 4)
            )
            .shadow(radius: 7)
        
    }
}

#Preview {
    CircleImage()
}
