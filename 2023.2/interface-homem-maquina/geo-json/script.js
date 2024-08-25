const fs = require("fs");

// Define the file paths
const inputFile = "geo-json/ufcg.geojson";
const outputFile = "geo-json/output.geojson";

const RED_COLORS = [
    "#FFEBEE",
    "#FFCDD2",
    "#EF9A9A",
    "#E57373",
    "#EF5350",
    "#F44336",
    "#E53935",
    "#D32F2F",
    "#C62828",
    "#B71C1C",
    "#FF8A80",
    "#FF5252",
    "#FF1744",
    "#D50000",
    "#FCE4EC",
    "#F8BBD0",
    "#F48FB1",
    "#F06292",
    "#EC407A",
    "#E91E63",
];

// Read from input file
fs.readFile(inputFile, "utf8", (err, data) => {
    if (err) {
        console.error("Error reading file:", err);
        return;
    }

    // Print the content of the input file
    console.log("Content of input file:");
    console.log(data);

    const dataObj = JSON.parse(data);

    const indicators = dataObj.features.map((feat) => ({
        ...feat,
        properties: {
            ...feat.properties,
            fill: RED_COLORS[Math.trunc(Math.random() * 19)],
        },
    }));

    // Write to output file
    fs.writeFile(
        outputFile,
        JSON.stringify({ ...dataObj, features: indicators }),
        "utf8",
        (err) => {
            if (err) {
                console.error("Error writing to file:", err);
                return;
            }

            console.log(`Data has been written to ${outputFile}`);
        }
    );
});
