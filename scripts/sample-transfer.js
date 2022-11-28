const { expect } = require("chai")
const { ConfluxSDK, conflux } = require("hardhat")
const fs = require('fs')
const xlsx = require('node-xlsx');
const { exit } = require("process");

async function main() {
    // 如果需要从xlsx文件中读取地址，可以用这段代码，需更改文件路径
    // const sheets = xlsx.parse('./address.xlsx');
    // const address = [];
    // sheets.forEach(sheet => {
    //     const data = sheet['data'];

    //     for (let rowId in data) {
    //         const row = data[rowId];
    //         address.push(row[0]);
    //     }
    // });

    const accounts = await conflux.getSigners();
    const account = accounts[0].address;

    // 获取合约实例
    const contractAddr = "";
    const contractInstance = await conflux.getContractAt('Test', contractAddr);

    // 需要空投的用户的地址
    const users = [];
    for (let i = 0; i < 10; i++) {
        users[i] = "";
    }

    // 需要空投的nft的token id
    const ids = [];
    for (let i = 1; i <= 10; i++) {
        ids.push(i);
    }

    // 进行空投
    let transferReceipt = await contractInstance.safeBatchTransferFrom(account, users, ids).sendTransaction({
        from: account
    }).executed();

    console.log(transferReceipt);
}

main()
    .then(() => process.exit(0))
    .catch((error) => {
        console.error(error);
        process.exit(1);
    });
