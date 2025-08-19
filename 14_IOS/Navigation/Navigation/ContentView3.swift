//
//  ContentView3.swift
//  Navigation
//
//  Created by Admin on 8/19/25.
//

import SwiftUI

struct ContentView3: View {
    @State private var showSheet = false
    
    var body: some View {
        Text("Hello, World")
            .padding(.bottom, 100)
        
        Button("모달(시트) 열기") {
            showSheet.toggle()
        }
        .sheet(isPresented: $showSheet) {
            ModalView()
        }
    }
}

struct ModalView: View {
    @Environment(\.dismiss) var dismiss
    
    var body: some View {
        Text("모달입니다.")
        Button("닫기") {
            dismiss()
        }
    }
}

#Preview {
    ContentView3()
}
